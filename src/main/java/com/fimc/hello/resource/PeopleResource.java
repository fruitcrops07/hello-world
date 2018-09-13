package com.fimc.hello.resource;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fimc.hello.exception.InvalidDateformatException;
import com.fimc.hello.model.Person;
import com.fimc.hello.util.DateHelper;

@Component
@Path("/people")
public class PeopleResource {

    private static List<Person> people = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchAll() {
        return Response.ok().entity(people).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerPerson(PersonRequest personRequest) {
        try {
            if (StringUtils.isEmpty(personRequest.getFirstName()) || StringUtils.isEmpty(personRequest.getLastName())
                || StringUtils.isEmpty(personRequest.getBirthDate()))
                return Response.status(HttpServletResponse.SC_BAD_REQUEST) //
                               .entity(new MessageResponse(HttpServletResponse.SC_BAD_REQUEST, "Invalid Request Body"))
                               .build();

            final Person person = new Person(personRequest.getFirstName(), //
                                             personRequest.getLastName(),
                                             DateHelper.parse(personRequest.getBirthDate()));
            people.add(person);
            return Response.status(HttpServletResponse.SC_CREATED).entity(people).build();
        } catch (InvalidDateformatException | ParseException e) {
            return Response.status(HttpServletResponse.SC_BAD_REQUEST) //
                           .entity(new MessageResponse(HttpServletResponse.SC_BAD_REQUEST, "Invalid format for birthDate"))
                           .build();
        }

    }
}
