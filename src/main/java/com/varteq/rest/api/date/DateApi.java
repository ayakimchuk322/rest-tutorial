package com.varteq.rest.api.date;

import com.varteq.rest.model.CalendarDate;
import com.varteq.rest.util.DateUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/date")
public class DateApi {

    public DateApi() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String now() {
        return DateUtil.getDateFromMilliseconds();
    }

    @GET
    @Path("/{day}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getDayOfWeek(@PathParam("day") String day) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("day of week", DateUtil.getDayOfWeek(day));

        return payload;
    }

    @GET
    @Path("/info/{day}")
    @Produces(MediaType.APPLICATION_JSON)
    public CalendarDate getDateInformation(@PathParam("day") String day) {
        return DateUtil.getDateInfo(day);
    }
}
