
package com.mycompany.myproject.sightly;

import javax.jcr.Node;
import javax.script.Bindings;
import org.apache.sling.api.resource.Resource;
import io.sightly.java.api.Use;

public class HeroTextInterfaceComponent implements Use {

	/** The hero text bean. */
    private HeroTextBean heroTextBean = null; 
    
	public void init(Bindings bindings) {
		
		 Resource resource = (Resource) bindings.get("resource");
		 Node currentNode = resource.adaptTo(Node.class);
		 
		 heroTextBean = new HeroTextBean(); 
	     
	     try {
			if(currentNode.hasProperty("jcr:Heading")){ 
			     heroTextBean.setHeadingText(currentNode.getProperty("./jcr:Heading").getString()); 
			 }
			if(currentNode.hasProperty("jcr:description")){ 
		         heroTextBean.setDescription(currentNode.getProperty("./jcr:description").getString()); 
		     }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		// TODO Auto-generated method stub
		
	     
	}

	public HeroTextBean getHeroTextBean() { 
	    return this.heroTextBean; 
	}

}