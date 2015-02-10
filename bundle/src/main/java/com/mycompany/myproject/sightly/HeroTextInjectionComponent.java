package com.mycompany.myproject.sightly; 
  
//import com.adobe.cq.sightly.WCMUse; 
import javax.jcr.Node; 
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.adapter.AdapterFactory;
import org.apache.sling.api.resource.Resource;
  
/** 
 * The Class HeroTextComponent. 
 */
@Component(metatype = true, immediate = true)
@Service
public class HeroTextInjectionComponent implements AdapterFactory  { 
  
    /** The hero text bean. */
	private HeroTextBean heroTextBean = null; 
    
    Resource resource;
    
	@Property(name = "adapters")
	protected static final String[] ADAPTER_CLASSES = { 
		HeroTextInjectionComponent.class.getName() 
	};
	
	@Property(name = "adaptables")
	protected static final String[] ADAPTABLE_CLASSES = { 
		Resource.class.getName() 
	};
	
	@SuppressWarnings("unchecked")
	public <AdapterType> AdapterType getAdapter(Object adaptable, Class<AdapterType> type) {
		if (adaptable instanceof Resource) {
			resource = (Resource) adaptable;
			HeroTextInjectionComponent comp = new HeroTextInjectionComponent();
			return (AdapterType) comp;
		}
		return null;
	}
	
	/*public HeroTextInjectionComponent(){  
        Node currentNode = resource.adaptTo(Node.class); 
         
        heroTextBean = new HeroTextBean(); 
          
        try {
			if(currentNode.hasProperty("jcr:Heading")){ 
			    heroTextBean.setHeadingText(currentNode.getProperty("./jcr:Heading").getString()); 
			}
			if(currentNode.hasProperty("jcr:description")){ 
	            heroTextBean.setDescription(currentNode.getProperty("./jcr:description").getString()); 
	        } 
	        
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
          
    }*/ 
      
    public HeroTextBean getHeroTextBean() { 
        return this.heroTextBean; 
    } 
}