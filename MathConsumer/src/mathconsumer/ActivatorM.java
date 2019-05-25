package mathconsumer;


import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import osgi.MathService.*;
import osgi.Util.*;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ActivatorM implements BundleActivator {

	private static BundleContext context;
	private MathService ms;
   
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		ActivatorM.context = bundleContext;
		System.out.println("MathConsumer Starting...");
		
		//under these method calling from MathService project to here;
		System.out.println("5-3= "+MathUtil.minus(5, 3));
		
		//
		this.run();
		System.out.println("Math Consumer started..");
	}

	public void  run() {
		ServiceReference serviceReference= context.getServiceReference(MathService.class);
		if(serviceReference!=null) {
			ms=(MathService)context.getService(serviceReference);
			
			if(ms!=null) {
				Cal.run(ms);
				context.ungetService(serviceReference);
			}
		}
		
	
	}
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		ActivatorM.context = null;
		System.out.println("Stopped...");
	}

}
