import com.kovalenkovolodymyr.builder.NewsApiConst;
import com.kovalenkovolodymyr.builder.impl.EverythingNewsApiRequestBuilder;
import com.kovalenkovolodymyr.builder.impl.TopHeadlinesNewsApiRequestBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import static java.net.HttpURLConnection.HTTP_OK;

public class NewsApiRequestBuilderTest {

    @Test
    public void topHeadlinesBuilderPositiveTest() {
        Response topHeadlinesResponse = TopHeadlinesNewsApiRequestBuilder.builder()
                .apiKey(NewsApiConst.API_KEY)
                .country("ca")
                .category("entertainment")
                .page(1)
                .build()
                .request(MediaType.APPLICATION_JSON_TYPE).get();
        String entity = topHeadlinesResponse.readEntity(String.class);
        Assert.assertEquals(topHeadlinesResponse.getStatus(), HTTP_OK, entity);
        System.out.println(entity);
    }

    @Test
    public void everythingBuilderPositiveTest() {
        Response everythingResponse = EverythingNewsApiRequestBuilder.builder()
                .apiKey(NewsApiConst.API_KEY)
                .from("2018-11-23")
                .to("2018-11-24")
                .q("Fifa")
                .page(1)
                .build()
                .request(MediaType.APPLICATION_JSON_TYPE).get();
        String entity = everythingResponse.readEntity(String.class);
        Assert.assertEquals(everythingResponse.getStatus(), HTTP_OK, entity);
        System.out.println(entity);
    }
}
