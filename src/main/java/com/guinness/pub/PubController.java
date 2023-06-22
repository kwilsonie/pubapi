package com.guinness.pub;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guinness.pub.api.Point;
import com.guinness.pub.api.Pub;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController 
@RequestMapping("/api/0.1")

public class PubController {

	@GetMapping("/date")
	public String date() {
		   SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		   Date date = new Date();  
		   return formatter.format(date);  
	}

    @GetMapping(path = "/{pubId}", produces = "application/json")
    public Pub getPub(@PathVariable int pubId, @RequestHeader Map<String, String> headers, HttpServletRequest request,
                    HttpServletResponse response) {
            try {
/*                    PubEntity pubEntity = service.get(pubId);
                            
                    if (pubEntity == null) {
                            return null;
                    }
  */
           
            		Pub pub = new Pub();
            		pub.setId(pubId);

                    pub.setName("Athgarvan Inn");
                    pub.setDescription("This is a fine pub, great service and a good selection of food. Tried a number of dishes and they were all tasty, the standard you would expect in a pub. The Guinness and coors were very good also. Reasonable pricing too");
                    pub.setEmail("info@athgarvaninn.com");
                    pub.setPhone("(045) 481 626");
                    pub.setLine1(" Newbridge Rd");
                    pub.setLine2("Rosetown");
                    pub.setRegion("");
                    pub.setCity("Athgarvan");
                    pub.setCounty_province("Kildare");
                    pub.setZip_or_postcode("W12 PK00");
                    pub.setCountry("Ireland");
                    pub.setCoordinate(new Point(53.153352351320, -6.777560913571852));
                    
                  
/*            	
                    Pub pub = new Pub();
                    pub.setId(pubEntity.id);
                    pub.setName(pubEntity.name);
                    pub.setDescription(String.valueOf(pubEntity.description));
                    pub.setEmail(pubEntity.email);
                    pub.setPhone(pubEntity.phone);
                    pub.setLine1(pubEntity.line1);
                    pub.setLine2(pubEntity.line2);
                    pub.setRegion(pubEntity.region);
                    pub.setCity(pubEntity.city);
                    pub.setCounty_province(pubEntity.countyOrProvince);
                    pub.setZip_or_postcode(pubEntity.zipOrPostcode);
                    pub.setCountry(pubEntity.country);
                    pub.setCoordinate(new Point(pubEntity.latitude, pubEntity.longitude));
                    pub.setId(pubEntity.id);
                    pub.setTimestamp(pubEntity.timestamp); */
            	
                    response.setStatus(HttpServletResponse.SC_OK);
                    return pub;
            } catch (Exception e) {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    return null;
            }       
    }               

    
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Pub addPub(@RequestBody Pub pub, @RequestHeader Map<String, String> headers,
                                  HttpServletRequest request, HttpServletResponse response)
    {
 
	    try { 
	        response.setStatus(HttpServletResponse.SC_OK);
	        return pub;
	    } catch (Exception e) {
	        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	        return null;
	    }
    }
    
	
}
