import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Test;


public class Posttest {

	@Test

	void posttest ()

	{

		Map<String, Object>  mp = new HashMap<String, Object>();

	mp.put("name", "morpheus");

	mp.put("job", "leader");

	System.out.println(mp);

	JSONObject req = new JSONObject(mp);

	System.out.println(req);




	}
}