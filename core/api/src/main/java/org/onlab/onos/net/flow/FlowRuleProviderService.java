package org.onlab.onos.net.flow;

import org.onlab.onos.net.provider.ProviderService;

/**
 * Service through which flow rule providers can inject information into
 * the core.
 */
public interface FlowRuleProviderService extends ProviderService<FlowRuleProvider> {

    /**
     * Signals that a flow rule that was previously installed has been removed.
     *
     * @param flowRule information about the removed flow
     */
    void flowRemoved(FlowRule flowRule);

    /**
     * Signals that a flow rule is missing for some network traffic.
     *
     * @param flowRule information about traffic in need of flow rule(s)
     */
    void flowMissing(FlowRule flowRule);

}
