package com.fimc.hello.resource;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fimc.hello.exception.DivisionOfZeroException;
import com.fimc.hello.exception.InvalidOperatorException;
import com.fimc.hello.util.Calculator;

@Component
@Path("/calculator")
public class CalculatorResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculate(CalculationRequest calculationRequest) {
        try {
            if (StringUtils.isEmpty(calculationRequest.getOperator()) || calculationRequest.getNumber1() == null
                || calculationRequest.getNumber2() == null)
                return Response.status(HttpServletResponse.SC_BAD_REQUEST) //
                               .entity(new MessageResponse(HttpServletResponse.SC_BAD_REQUEST, "Invalid Request Body"))
                               .build();

            final CalculationResponse result = new CalculationResponse();
            result.setResult(Calculator.calculate(calculationRequest.getOperator(), //
                                                  calculationRequest.getNumber1(),
                                                  calculationRequest.getNumber2()));
            result.setAction(Calculator.translateOperator(calculationRequest.getOperator()));
            return Response.ok().status(HttpServletResponse.SC_OK).entity(result).build();
        } catch (DivisionOfZeroException e) {
            return Response.status(HttpServletResponse.SC_BAD_REQUEST) //
                           .entity(new MessageResponse(HttpServletResponse.SC_BAD_REQUEST, "Division of Zero is invalid"))
                           .build();
        } catch (InvalidOperatorException e) {
            return Response.status(HttpServletResponse.SC_BAD_REQUEST) //
                           .entity(new MessageResponse(HttpServletResponse.SC_BAD_REQUEST, "Invalid Operation"))
                           .build();
        }
    }

}
