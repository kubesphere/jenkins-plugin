package io.jenkins.plugins;

import hudson.model.FreeStyleBuild;
import hudson.model.FreeStyleProject;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import static org.junit.Assert.*;

public class KubernetesDeployTest {
    @Rule
    public JenkinsRule r = new JenkinsRule();

    @Test
    public void checkKubernetesDeploy() throws Exception{
        //Given
        String config = "wwwasdasd";
        KubernetesDeployContext context = new KubernetesDeployContext(config);
        KubernetesDeploy deploy = new KubernetesDeploy(context);
        FreeStyleProject p = r.createFreeStyleProject();
        p.getBuildersList().add(deploy);

        //When
        FreeStyleBuild freeStyleBuild = p.scheduleBuild2(0).get();

        //Then
        String a = freeStyleBuild.getLog();
        System.out.println(a);
        assertTrue(freeStyleBuild.getLog().contains("wwwasdasd"));

    }
}