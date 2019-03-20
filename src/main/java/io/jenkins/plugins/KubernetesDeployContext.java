package io.jenkins.plugins;

import org.kohsuke.stapler.DataBoundConstructor;

public class KubernetesDeployContext {
    private final String config;

    @DataBoundConstructor
    public KubernetesDeployContext(String config) {
        this.config = config;
    }
}
