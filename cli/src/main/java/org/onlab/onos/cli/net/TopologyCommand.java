package org.onlab.onos.cli.net;

import org.apache.karaf.shell.commands.Command;
import org.onlab.onos.cli.AbstractShellCommand;
import org.onlab.onos.net.topology.Topology;
import org.onlab.onos.net.topology.TopologyService;

/**
 * Lists summary of the current topology.
 */
@Command(scope = "onos", name = "topology",
         description = "Lists summary of the current topology")
public class TopologyCommand extends AbstractShellCommand {

    private static final String FMT =
            "time=%s, devices=%d, links=%d, clusters=%d, paths=%d";

    protected TopologyService service;
    protected Topology topology;

    /**
     * Initializes the context for all cluster commands.
     */
    protected void init() {
        service = getService(TopologyService.class);
        topology = service.currentTopology();
    }

    @Override
    protected Object doExecute() throws Exception {
        init();
        print(FMT, topology.time(), topology.deviceCount(), topology.linkCount(),
              topology.clusterCount(), topology.pathCount());
        return null;
    }

}