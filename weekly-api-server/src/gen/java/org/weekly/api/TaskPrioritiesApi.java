package org.weekly.api;

import org.weekly.model.TaskPriority;

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
public interface TaskPrioritiesApi  {

    /**
     * Get all task priorities.
     *
     */
    @GET
    @Path("/task/priorities")
    @Produces({ "application/json" })
    @ApiOperation(value = "Get all task priorities.", tags={ "task-priorities" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = ".", response = TaskPriority.class) })
    public TaskPriority getTaskPriorities();
}
