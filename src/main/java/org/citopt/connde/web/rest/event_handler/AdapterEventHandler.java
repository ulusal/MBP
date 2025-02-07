package org.citopt.connde.web.rest.event_handler;

import org.citopt.connde.domain.adapter.Adapter;
import org.citopt.connde.domain.component.Actuator;
import org.citopt.connde.domain.component.Sensor;
import org.citopt.connde.repository.ActuatorRepository;
import org.citopt.connde.repository.SensorRepository;
import org.citopt.connde.repository.ValueLogRepository;
import org.citopt.connde.repository.projection.ComponentProjection;
import org.citopt.connde.service.deploy.SSHDeployer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Event handler for operations that are performed on adapters.
 */
@Component
@RepositoryEventHandler
public class AdapterEventHandler {
    @Autowired
    private ActuatorRepository actuatorRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private ValueLogRepository valueLogRepository;

    @Autowired
    private SSHDeployer sshDeployer;

    /**
     * Called in case an adapter is supposed to be deleted. This method then takes care of deleting
     * the components which use this adapter and the associated value logs.
     *
     * @param adapter The adapter that is supposed to be deleted
     */
    @HandleBeforeDelete
    public void beforeAdapterDelete(Adapter adapter) throws IOException {
        String adapterId = adapter.getId();

        //Find actuators that use this adapter and iterate over them
        List<ComponentProjection> affectedActuators = actuatorRepository.findAllByAdapterId(adapterId);
        for (ComponentProjection projection : affectedActuators) {
            Actuator actuator = actuatorRepository.findOne(projection.getId());

            //Undeploy actuator if running
            sshDeployer.undeployIfRunning(actuator);

            //TODO Delete value logs with idref actuator.getId()

            //Delete actuator
            actuatorRepository.delete(projection.getId());
        }

        //Find sensors that use this adapter and iterate over them
        List<ComponentProjection> affectedSensors = sensorRepository.findAllByAdapterId(adapterId);
        for (ComponentProjection projection : affectedSensors) {
            Sensor sensor = sensorRepository.findOne(projection.getId());

            //Undeploy sensor if running
            sshDeployer.undeployIfRunning(sensor);

            //TODO Delete value logs with idref sensor.getId()

            //Delete sensor
            sensorRepository.delete(projection.getId());
        }
    }
}
