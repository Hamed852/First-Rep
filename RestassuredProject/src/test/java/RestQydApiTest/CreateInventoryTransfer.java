package RestQydApiTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;

public class CreateInventoryTransfer {

	public static void createInvTransferTest() {

		JSONObject CRReq = new JSONObject();
		JSONObject inventory_transfer = new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


		"date": "{{inv_tra_date}}",
		"description": "{{inv_tra_descr}}",
		

		int Loc1_ID  ;
		int Loc2_ID  ;

		Date inv_Transfer_date ;
		String orderNotes = fk.funnyName().name();

		String orderTerms = fk.name().nameWithMiddle();

		order.put("contact_id", "270");


		
		
	}
}
