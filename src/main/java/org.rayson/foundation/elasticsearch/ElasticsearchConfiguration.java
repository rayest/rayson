package org.rayson.foundation.elasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-11-28
 *  Time: 10:53 AM
 *  Description:
 **/
@Configuration
//@EnableElasticsearchRepositories(basePackages = "org.rayson.foundation.elasticsearch")
@Slf4j
public class ElasticsearchConfiguration {

  @Value("${spring.data.elasticsearch.cluster-nodes}")
  private String clusterNodes;

  @Value("${spring.data.elasticsearch.cluster-name}")
  private String clusterName;

  //@Bean
  //public Client client() throws Exception {
  //  Settings settings = Settings.builder()
  //      .put("cluster.name", clusterName)
  //      .build();
  //
  //  TransportClient client = new PreBuiltTransportClient(settings);
  //  TransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300);
  //  client.addTransportAddress(address);
  //  return client;
  //}
  //
  //@Bean
  //public ElasticsearchOperations elasticsearchTemplate() throws Exception {
  //  return new ElasticsearchTemplate(client());
  //}

}
