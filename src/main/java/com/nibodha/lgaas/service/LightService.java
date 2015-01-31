package com.nibodha.lgaas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibodha.lgaas.dao.ActivationKeyDao;
import com.nibodha.lgaas.dao.CrimeUpdateEntitiyDao;
import com.nibodha.lgaas.dao.DeviceDao;
import com.nibodha.lgaas.dao.LightDao;
import com.nibodha.lgaas.entity.ActivationKey;
import com.nibodha.lgaas.entity.CrimeUpdateEntity;
import com.nibodha.lgaas.entity.Device;
import com.nibodha.lgaas.entity.Light;

@Service
public class LightService {
	@Autowired
	LightActionService lightActionService;
	
	@Autowired
	private LightDao lightDao;
	
	@Autowired
	private DeviceDao deviceDao;
	
	@Autowired
	private ActivationKeyDao activationKeyDao;
	
	@Autowired
	private CrimeUpdateEntitiyDao crimeUpdateEntityDao;
	
	public void saveInitialLight(){
		Device device1 = new Device();
		device1.setId(1L);
		device1.setIpAddress("localhost");
		device1.setPort("2323");
		device1.setLocation("Startup Village");
		
		ActivationKey activationKey1 = new ActivationKey();
		activationKey1.setDevice(device1);
		activationKey1.setKey("39dju9le29");

		Light light1 = new Light();
		light1.setId(1L);
		light1.setLightlat("12.88765579");
		light1.setLightlot("13.0887876");
		light1.setLightStatus("icon_light light_on");
		light1.setLightTemperature("37 Degree");
		light1.setLightVoltage("1000 V");
		light1.setZone("Cochin");
		light1.setDescription("1000V Bulb placed backside of startup village");
		light1.setName("SV_L1");
		light1.setDevicename(device1);
		light1.setTimestamp("20/01/2015 11:58 AM");
		
		Light light2 = new Light();
		light2.setId(2L);
		light2.setLightlat("12.88765579");
		light2.setLightlot("13.0887866");
		light2.setLightStatus("icon_light light_on");
		light2.setLightTemperature("35 Degree");
		light2.setLightVoltage("1500 V");
		light2.setZone("Cochin");
		light2.setDescription("1000V Bulb placed backside of startup village");
		light2.setName("SV_L2");
		light2.setDevicename(device1);
		light2.setTimestamp("20/01/2015 11:58 AM");
		
		Light light3 = new Light();
		light3.setId(3L);
		light3.setLightlat("12.88765579");
		light3.setLightlot("13.0887876");
		light3.setLightStatus("icon_light light_on");
		light3.setLightTemperature("40 Degree");
		light3.setLightVoltage("1000 V");
		light3.setZone("Cochin");
		light3.setDescription("1000V Bulb placed backside of startup village");
		light3.setName("SV_L3");
		light3.setDevicename(device1);
		light3.setTimestamp("20/01/2015 11:58 AM");
		
		Light light4 = new Light();
		light4.setId(4L);
		light4.setLightlat("12.88765579");
		light4.setLightlot("13.0887876");
		light4.setLightStatus("icon_light light_on");
		light4.setLightTemperature("45 Degree");
		light4.setLightVoltage("100 V");
		light4.setZone("Cochin");
		light4.setDescription("1000V Bulb placed backside of startup village");
		light4.setName("SV_L4");
		light4.setDevicename(device1);
		light4.setTimestamp("20/01/2015 11:58 AM");
		
		Light light5 = new Light();
		light5.setId(5L);
		light5.setLightlat("12.88765579");
		light5.setLightlot("13.0887876");
		light5.setLightStatus("icon_light light_on");
		light5.setLightTemperature("icon_light light_dim");
		light5.setLightVoltage("100 V");
		light5.setZone("Cochin");
		light5.setDescription("1000V Bulb placed backside of startup village");
		light5.setName("SV_L5");
		light5.setDevicename(device1);
		light5.setTimestamp("20/01/2015 11:58 AM");
		
		Light light6 = new Light();
		light6.setId(6L);
		light6.setLightlat("12.88765579");
		light6.setLightlot("13.0887876");
		light6.setLightStatus("icon_light light_on");
		light6.setLightTemperature("icon_light light_dim");
		light6.setLightVoltage("100 V");
		light6.setZone("Cochin");
		light6.setDescription("1000V Bulb placed backside of startup village");
		light6.setName("SV_L6");
		light6.setDevicename(device1);
		light6.setTimestamp("20/01/2015 11:58 AM");
		
		Light light7 = new Light();
		light7.setId(7L);
		light7.setLightlat("12.88765579");
		light7.setLightlot("13.0887876");
		light7.setLightStatus("icon_light light_on");
		light7.setLightTemperature("30 Degree");
		light7.setLightVoltage("1000 V");
		light7.setZone("Cochin");
		light7.setDescription("1000V Bulb placed backside of startup village");
		light7.setName("SV_L7");
		light7.setDevicename(device1);
		light7.setTimestamp("20/01/2015 11:58 AM");
		
		Light light8 = new Light();
		light8.setId(8L);
		light8.setLightlat("12.88765579");
		light8.setLightlot("13.0887876");
		light8.setLightStatus("icon_light light_on");
		light8.setLightTemperature("30 Degree");
		light8.setLightVoltage("100 V");
		light8.setZone("Cochin");
		light8.setDescription("1000V Bulb placed backside of startup village");
		light8.setName("SV_L8");
		light8.setDevicename(device1);
		light8.setTimestamp("20/01/2015 11:58 AM");
		
		Light light9 = new Light();
		light9.setId(9L);
		light9.setLightlat("12.88765579");
		light9.setLightlot("13.0887886");
		light9.setLightStatus("icon_light light_on");
		light9.setLightTemperature("30 Degree");
		light9.setLightVoltage("100 V");
		light9.setZone("Cochin");
		light9.setDescription("1000V Bulb placed backside of startup village");
		light9.setName("SV_L9");
		light9.setDevicename(device1);
		light9.setTimestamp("20/01/2015 11:58 AM");
		
		Light light10 = new Light();
		light10.setId(10L);
		light10.setLightlat("12.88765579");
		light10.setLightlot("13.0887876");
		light10.setLightStatus("icon_light light_on");
		light10.setLightTemperature("30 Degree");
		light10.setLightVoltage("100 V");
		light10.setZone("Cochin");
		light10.setDescription("1000V Bulb placed backside of startup village");
		light10.setName("SV_L10");
		light10.setDevicename(device1);
		light10.setTimestamp("20/01/2015 11:58 AM");
		
		Light light11 = new Light();
		light11.setId(11L);
		light11.setLightlat("12.88765579");
		light11.setLightlot("13.0887876");
		light11.setLightStatus("icon_light light_on");
		light11.setLightTemperature("30 Degree");
		light11.setLightVoltage("100 V");
		light11.setZone("Cochin");
		light11.setDescription("1000V Bulb placed backside of startup village");
		light11.setName("SV_L11");
		light11.setDevicename(device1);
		light11.setTimestamp("20/01/2015 11:58 AM");
		
		Light light12 = new Light();
		light12.setId(12L);
		light12.setLightlat("12.88765579");
		light12.setLightlot("13.0887876");
		light12.setLightStatus("icon_light light_on");
		light12.setLightTemperature("30 Degree");
		light12.setLightVoltage("100 V");
		light12.setZone("Cochin");
		light12.setDescription("1000V Bulb placed backside of startup village");
		light12.setName("SV_L12");
		light12.setDevicename(device1);
		light12.setTimestamp("20/01/2015 11:58 AM");
		
		Light light13 = new Light();
		light13.setId(13L);
		light13.setLightlat("12.88765579");
		light13.setLightlot("13.0887876");
		light13.setLightStatus("icon_light light_on");
		light13.setLightTemperature("30 Degree");
		light13.setLightVoltage("100 V");
		light13.setZone("Cochin");
		light13.setDescription("1000V Bulb placed backside of startup village");
		light13.setName("SV_L13");
		light13.setDevicename(device1);
		light13.setTimestamp("20/01/2015 11:58 AM");
		
		Light light14 = new Light();
		light14.setId(14L);
		light14.setLightlat("12.88765579");
		light14.setLightlot("13.0887876");
		light14.setLightStatus("icon_light light_on");
		light14.setLightTemperature("30 Degree");
		light14.setLightVoltage("100 V");
		light14.setZone("Cochin");
		light14.setDescription("1000V Bulb placed backside of startup village");
		light14.setName("SV_L14");
		light14.setDevicename(device1);
		light14.setTimestamp("20/01/2015 11:58 AM");
		
		Light light15 = new Light();
		light15.setId(15L);
		light15.setLightlat("12.88765579");
		light15.setLightlot("13.0887876");
		light15.setLightStatus("icon_light light_on");
		light15.setLightTemperature("30 Degree");
		light15.setLightVoltage("100 V");
		light15.setZone("Cochin");
		light15.setDescription("1000V Bulb placed backside of startup village");
		light15.setName("SV_L15");
		light15.setDevicename(device1);
		light15.setTimestamp("20/01/2015 11:58 AM");
		
		Light light16 = new Light();
		light16.setId(16L);
		light16.setLightlat("12.88765579");
		light16.setLightlot("13.0887876");
		light16.setLightStatus("icon_light light_on");
		light16.setLightTemperature("30 Degree");
		light16.setLightVoltage("100 V");
		light16.setZone("Cochin");
		light16.setDescription("1000V Bulb placed backside of startup village");
		light16.setName("SV_L16");
		light16.setDevicename(device1);
		light16.setTimestamp("20/01/2015 11:58 AM");
		
		Light light17 = new Light();
		light17.setId(17L);
		light17.setLightlat("12.88765579");
		light17.setLightlot("13.0887876");
		light17.setLightStatus("icon_light light_on");
		light17.setLightTemperature("30 Degree");
		light17.setLightVoltage("100 V");
		light17.setZone("Cochin");
		light17.setDescription("1000V Bulb placed backside of startup village");
		light17.setName("SV_L17");
		light17.setDevicename(device1);
		light17.setTimestamp("20/01/2015 11:58 AM");
		
		Light light18 = new Light();
		light18.setId(18L);
		light18.setLightlat("12.88765579");
		light18.setLightlot("13.0887876");
		light18.setLightStatus("icon_light light_on");
		light18.setLightTemperature("30 Degree");
		light18.setLightVoltage("100 V");
		light18.setZone("Cochin");
		light18.setDescription("1000V Bulb placed backside of startup village");
		light18.setName("SV_L18");
		light18.setDevicename(device1);
		light18.setTimestamp("20/01/2015 11:58 AM");
		
		Light light19 = new Light();
		light19.setId(19L);
		light19.setLightlat("12.88765579");
		light19.setLightlot("13.0887876");
		light19.setLightStatus("icon_light light_on");
		light19.setLightTemperature("30 Degree");
		light19.setLightVoltage("100 V");
		light19.setZone("Cochin");
		light19.setDescription("1000V Bulb placed backside of startup village");
		light19.setName("SV_L19");
		light19.setDevicename(device1);
		light19.setTimestamp("20/01/2015 11:58 AM");
		
		Light light20 = new Light();
		light20.setId(20L);
		light20.setLightlat("12.88765579");
		light20.setLightlot("13.0887876");
		light20.setLightStatus("icon_light light_on");
		light20.setLightTemperature("30 Degree");
		light20.setLightVoltage("100 V");
		light20.setZone("Cochin");
		light20.setDescription("1000V Bulb placed backside of startup village");
		light20.setName("SV_L20");
		light20.setDevicename(device1);
		light20.setTimestamp("20/01/2015 11:58 AM");
		
		Light light21 = new Light();
		light21.setId(21L);
		light21.setLightlat("12.88765579");
		light21.setLightlot("13.0887876");
		light21.setLightStatus("icon_light light_on");
		light21.setLightTemperature("30 Degree");
		light21.setLightVoltage("100 V");
		light21.setZone("Cochin");
		light21.setDescription("1000V Bulb placed backside of startup village");
		light21.setName("SV_L21");
		light21.setDevicename(device1);
		light21.setTimestamp("20/01/2015 11:58 AM");
		
		deviceDao.save(device1);
		activationKeyDao.save(activationKey1);
		lightDao.save(light1);
		lightDao.save(light2);
		lightDao.save(light3);
		lightDao.save(light4);
		lightDao.save(light5);
		lightDao.save(light6);
		lightDao.save(light7);
		lightDao.save(light8);
		lightDao.save(light9);
		lightDao.save(light10);
		lightDao.save(light11);
		lightDao.save(light12);
		lightDao.save(light13);
		lightDao.save(light14);
		lightDao.save(light15);
		lightDao.save(light16);
		lightDao.save(light17);
		lightDao.save(light18);
		lightDao.save(light19);
		lightDao.save(light20);
		lightDao.save(light21);

		
		
		
	}
	public void addDummyData() {
		// TODO Auto-generated method stub
		List<Light> lightList = lightDao.findAll();
		if(lightList.size()<=1){
			saveInitialLight();
		}
	}
	public List<Light> findAllLights() {
		// TODO Auto-generated method stub
		 
		return lightDao.findAll();
		
	}
	public void changeLightStatus(Long lightid, String lightStatus) {
		// TODO Auto-generated method stub
		Long level = 0l;
		Light currentLight = lightDao.findOne(lightid);
		if(currentLight != null){
			currentLight.setLightStatus(lightStatus);
			lightDao.save(currentLight);
			if(lightStatus.equalsIgnoreCase("icon_light light_dim")){
				level = 1l;
			}else if(lightStatus.equalsIgnoreCase("icon_light light_alert")){
				level = 2l;
			}else if(lightStatus.equalsIgnoreCase("icon_light light_fused")){
				level = 3l;
			}else if(lightStatus.equalsIgnoreCase("icon_light light_on")){
				level = 4l;
			}
			try {
				String result = lightActionService.blinkLight(level,lightid,null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void newCrimeUpdate(String longitude, String latitude) {
		// TODO Auto-generated method stub
		CrimeUpdateEntity crimeUpdateEntity = new CrimeUpdateEntity();
		crimeUpdateEntity.setLatitude(latitude);
		crimeUpdateEntity.setLotitude(longitude);
		crimeUpdateEntity.setStatus("Active");
		crimeUpdateEntityDao.save(crimeUpdateEntity);
		
	}
	

}
