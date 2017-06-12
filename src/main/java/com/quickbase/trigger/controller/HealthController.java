package com.quickbase.trigger.controller;

import com.quickbase.trigger.models.HealthCheckStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 *
 * <b>HealthController</b> <br>
 * <br>
 * This class controls the health controller end point of the trigger service.
 *
 */
@RestController
@RequestMapping(value = "/api/v1/health", produces = APPLICATION_JSON_VALUE)
@Api(value = "/api/v1/health", description = "Health Check Endpoints")
public class HealthController {
    @RequestMapping(method = GET)
    @ApiOperation(value = "Run an End to End check on the system",
        notes = "Calls through the back end dependencies to verify that they are available.",
        httpMethod = "GET",
        response = HealthCheckStatus.class,
        responseContainer = "")
    public HealthCheckStatus health() {
        HealthCheckStatus status = new HealthCheckStatus();
        status.setSqlDate(new Date());
        return status;
    }
}
