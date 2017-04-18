package zlw80s.utils;

public class IDGenerator {
	
	
	public static String UUID(){		
		return UUIDGenerator.getUUID();		
	}
	
	public static String UUID(String name){
		return UUIDGenerator.getUUID(name);
	}
	
	public static String SnowFlake(long datacenterId, long machineId){
		return String.valueOf(new SnowFlake(datacenterId,machineId).nextId());		
	}
	
}
