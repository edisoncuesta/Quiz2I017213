package Parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Models.User;

/**
 * Created by TOSHIBA1 on 19/04/2018.
 */

public class Json {

    public static List<User> getData(String content) throws JSONException {

        JSONArray jsonArray = new JSONArray(content);
        List<User> postList = new ArrayList<>();
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject item = jsonArray.getJSONObject(i);
            JSONObject item2 = jsonArray.getJSONObject(Integer.parseInt("adrres"));

            User post = new User();
            post.setName(item.getString("name"));
            post.setUsername(item.getString("username"));
            post.setEmail(item.getString("email"));
            post.setStreet(item.getString("street"));

            postList.add(post);

        }

        return postList;
    }

}


