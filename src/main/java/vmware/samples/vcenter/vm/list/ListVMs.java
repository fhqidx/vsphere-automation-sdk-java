/*
 * *******************************************************
 * Copyright VMware, Inc. 2017.  All Rights Reserved.
 * SPDX-License-Identifier: MIT
 * *******************************************************
 *
 * DISCLAIMER. THIS PROGRAM IS PROVIDED TO YOU "AS IS" WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, WHETHER ORAL OR WRITTEN,
 * EXPRESS OR IMPLIED. THE AUTHOR SPECIFICALLY DISCLAIMS ANY IMPLIED
 * WARRANTIES OR CONDITIONS OF MERCHANTABILITY, SATISFACTORY QUALITY,
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE.
 */
package vmware.samples.vcenter.vm.list;

import java.util.Collections;
import java.util.List;

import org.apache.commons.cli.Option;

import com.vmware.vcenter.VM;
import com.vmware.vcenter.VMTypes;
import com.vmware.vcenter.VMTypes.Summary;

import vmware.samples.common.SamplesAbstractBase;

/**
 * Description: Demonstrates getting list of VMs present in vCenter
 *
 * Author: VMware, Inc.
 * Sample Prerequisites: vCenter 6.5+
 */
public class ListVMs extends SamplesAbstractBase {
    private VM vmService;

    /**
     * Define the options specific to this sample and configure the sample using
     * command-line arguments or a config file
     *
     * @param args command line arguments passed to the sample
     */
    protected void parseArgs(String[] args) {
        super.parseArgs(Collections.<Option>emptyList(), args);
    }

    protected void setup() throws Exception {
        this.vmService = vapiAuthHelper.getStubFactory().createStub(VM.class, sessionStubConfig);
    }

    protected void run() throws Exception {
        List<Summary> vmList = this.vmService.list(new VMTypes.FilterSpec.Builder().build());
        System.out.println("----------------------------------------");
        System.out.println("List of VMs");
        for (Summary vmSummary : vmList) {
        	System.out.println(vmSummary);
        }
        System.out.println("----------------------------------------");
    }
    protected void cleanup() throws Exception {
    	// No cleanup required
    }
    
    public static void main(String[] args) throws Exception {
        /*
         * Execute the sample using the command line arguments or parameters
         * from the configuration file. This executes the following steps:
         * 1. Parse the arguments required by the sample
         * 2. Login to the server
         * 3. Setup any resources required by the sample run
         * 4. Run the sample
         * 5. Cleanup any data created by the sample run, if cleanup=true
         * 6. Logout of the server
         */
        new ListVMs().execute(args);
    }
}
