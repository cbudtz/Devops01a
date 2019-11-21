package rest;

import data.Metrics;
import io.prometheus.client.CollectorRegistry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.StringWriter;

@Path("metrics")
public class PrometheusService {

    @GET
    public String getPrometheusData(){
        Metrics.attemptCounter.inc(); // Hack - Data reporting only starts after one counter has been altered
        StringWriter writer = new StringWriter();
        try {
            io.prometheus.client.exporter.common.TextFormat.write004(
                    writer, CollectorRegistry.defaultRegistry.metricFamilySamples());
        } catch (Exception e) {
            return e.getMessage();
        }
        return writer.toString();
    }

}
