package cn.enilu.flash.api.controller.es;

import cn.enilu.flash.api.controller.BaseController;
import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

//import cn.enilu.flash.bean.entity.es.TestBean;
//import cn.enilu.flash.service.es.TestService;

@RestController
@RequestMapping("/test")
public class ESControllerController extends BaseController {
    @Autowired
    public RestHighLevelClient client;

    @RequestMapping("createIndex")
    public void findAll() throws IOException {
        CreateIndexRequest request =  new CreateIndexRequest("twitter");
        // 设置Request参数
        request.settings(Settings.builder()
                .put("index.number_of_shards", 3) // 设置分区数
                .put("index.number_of_replicas", 2) // 设置副本数
        );
        JSONObject mapping =  new JSONObject();
        JSONObject _doc =  new JSONObject();

        JSONObject properties =  new JSONObject();
        JSONObject message =  new JSONObject();
        message.put("type", "text");
        properties.put("message", message);
        _doc.put("properties",properties);

        mapping.put("_doc",_doc);

        request.mapping("_doc",mapping.toJSONString(), XContentType.JSON);

        // 执行请求，创建索引
        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);

        if (createIndexResponse.isAcknowledged()) {
            // 创建成功
            System.out.println("创建索引成功");

        }

    }

}
