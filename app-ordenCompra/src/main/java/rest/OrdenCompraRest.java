package rest;

import clients.ClienteRestClient;
import clients.ProductoRestClient;
import db.OrdenCompra;
import dtos.OrdenCompraDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import repo.OrdenCompraRepository;

import java.util.List;
import java.util.stream.Collectors;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional
public class OrdenCompraRest {
    @Inject
    OrdenCompraRepository repo;

    @Inject
    @RestClient
    ClienteRestClient clienteClient;

    @Inject
    @RestClient
    ProductoRestClient productoClient;

    @GET
    public List<OrdenCompraDto> findAll() {
        return repo.streamAll()
                .map(ordenCompra -> {
                    var cliente = clienteClient.findById(ordenCompra.getClienteId());
                    var producto = productoClient.findById(ordenCompra.getProductoId());

                    var dto = OrdenCompraDto.from(ordenCompra);

                    dto.setClienteId(cliente.getNombre());
                    dto.setProductoId(producto.getNombre());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id) {
        var orderCompra = repo.findByIdOptional(id);

        if (orderCompra.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(orderCompra.get()).build();
    }

    @POST
    public Response create(OrdenCompra obj) {
        obj.setId(null);

        repo.persist(obj);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")

    public Response update(@PathParam("id") Integer id, OrdenCompra obj) {

        OrdenCompra b = repo.findById(id);

        b.setPrecio(obj.getPrecio());
        b.setClienteId(obj.getClienteId());
        b.setProductoId(obj.getProductoId());
        return Response.ok()
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) {
        repo.deleteById(id);

        return Response.ok()
                .build();
    }
}
