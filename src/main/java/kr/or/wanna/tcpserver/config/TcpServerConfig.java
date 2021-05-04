package kr.or.wanna.tcpserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.ip.dsl.Tcp;
import org.springframework.integration.ip.tcp.connection.AbstractServerConnectionFactory;
import org.springframework.integration.transformer.GenericTransformer;

import kr.or.wanna.tcpserver.dto.DefaultSpec;
import kr.or.wanna.tcpserver.handler.CommandHandler;
import kr.or.wanna.tcpserver.seriallzer.TcpInputSerializer;
import kr.or.wanna.tcpserver.seriallzer.TcpOutputSerializer;

@EnableAutoConfiguration
@EnableIntegration
@IntegrationComponentScan
@Configuration
public class TcpServerConfig {
	@Autowired
	private CommandHandler commandHandler;
	
	@Bean
	public AbstractServerConnectionFactory serverConnectionFactory() {
		return Tcp.nioServer(1010).deserializer(new TcpInputSerializer()).serializer(new TcpOutputSerializer())
				.backlog(20).readDelay(1).id("server").get();
	}

	@Bean
	public IntegrationFlow inbound(AbstractServerConnectionFactory connectionFactory) {
		return IntegrationFlows.from(Tcp.inboundAdapter(connectionFactory))
				.transform(new GenericTransformer<DefaultSpec, DefaultSpec>() {

					@Override
					public DefaultSpec transform(DefaultSpec defaultSpec) {
						return commandHandler.exec(defaultSpec);
					}
				})
//				.log(msg -> "msg is " + msg)
				.channel("toObAdapter").get();
	}

	@Bean
	public IntegrationFlow outbound(AbstractServerConnectionFactory connectionFactory) {
		return f -> f.channel("toObAdapter")
//				.log(msg -> "msg is " + msg)
				.handle(Tcp.outboundAdapter(connectionFactory));
	}
}
