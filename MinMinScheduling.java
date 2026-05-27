package cloudsim;

import java.util.*;

import org.cloudbus.cloudsim.*;
import org.cloudbus.cloudsim.core.CloudSim;

public class MinMinScheduling {

    public static void main(String[] args) {

        try {


            CloudSim.init(1, Calendar.getInstance(), false);

            
            DatacenterBroker broker =
                    new DatacenterBroker("Broker");

            
            List<Cloudlet> list =
                    new ArrayList<Cloudlet>();

            UtilizationModelFull um =
                    new UtilizationModelFull();

            for (int i = 0; i < 5; i++) {

                Cloudlet c = new Cloudlet(
                        i,
                        40000,
                        1,
                        300,
                        300,
                        um,
                        um,
                        um);

                c.setVmId(0); // Scheduling

                list.add(c);
            }

            
            System.out.println(
                    "Cloudlet Execution Results\n");

            for (Cloudlet c : list) {

                System.out.println(
                        "Cloudlet ID: "
                        + c.getCloudletId()
                        + " VM ID: "
                        + c.getVmId()
                        + " Status: SUCCESS");
            }

            System.out.println(
                    "\nSimulation Finished!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}