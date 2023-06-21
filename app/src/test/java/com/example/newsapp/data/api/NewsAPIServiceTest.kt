package com.example.newsapp.data.api

import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NewsAPIServiceTest  {
    private lateinit var service: NewsAPIService
    private lateinit var server : MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    private fun enqueueMockResponse(
        fileName:String
    ){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopheadlines_sentRequest_reciveExpected(){
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadline("us",1).body()
            val request = server.takeRequest()
            val requestPath = request.path
            Truth.assertThat(responseBody).isNotNull()
            Truth.assertThat(requestPath).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=bd766cbbc9c84b41b195ca73e74c67d3")
        }
    }
    @Test
    fun getTopHeadlines_receivedResponse_correctPageSize(){
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadline("us",1).body()
            val articlesList = responseBody!!.articles
            Truth.assertThat(articlesList.size).isEqualTo(20)
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctContent(){
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadline("us",1).body()
            val articlesList = responseBody!!.articles
            val article = articlesList[2]
            Truth.assertThat(article.author).isEqualTo("Zachary B. Wolf")
            Truth.assertThat(article.url).isEqualTo("https://www.cnn.com/2023/06/20/politics/trump-indictment-cabinet-secretaries-what-matters/index.html")
            Truth.assertThat(article.publishedAt).isEqualTo("2023-06-20T04:02:00Z")

        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}