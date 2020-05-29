package org.weekly.api;

import org.weekly.model.Week;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.ext.multipart.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.jaxrs.PATCH;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Weekly
 *
 * <p>No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 */
@Path("/")
@Api(value = "/", description = "")
public interface CalendarApi  {

    /**
     * Get current week based on a timezone
     *
     */
    @GET
    @Path("/week")
    @Produces({ "application/json" })
    @ApiOperation(value = "Get current week based on a timezone", tags={ "calendar",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The current week", response = Week.class) })
    public Week getCurrentWeek(@QueryParam("tz") @NotNull  String tz);

    /**
     * Get next week.
     *
     */
    @GET
    @Path("/week/next")
    @Produces({ "application/json" })
    @ApiOperation(value = "Get next week.", tags={ "calendar",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The next week", response = Week.class) })
    public Week getNextWeek(@QueryParam("weekNo") @NotNull  Integer weekNo, @QueryParam("weekYear") @NotNull  Integer weekYear);

    /**
     * Get previous week.
     *
     */
    @GET
    @Path("/week/previous")
    @Produces({ "application/json" })
    @ApiOperation(value = "Get previous week.", tags={ "calendar" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The previous week", response = Week.class) })
    public Week getPreviousWeek(@QueryParam("weekNo") @NotNull  Integer weekNo, @QueryParam("weekYear") @NotNull  Integer weekYear);
}

