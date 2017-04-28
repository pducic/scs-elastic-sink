/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package demo;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.messaging.SubscribableChannel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dave Syer
 *
 */
@EnableBinding(AckSink.AckSinkChannel.class)
public class AckSink {

	private static Logger logger = LoggerFactory.getLogger(AckSink.class);
	private Jackson2JsonObjectMapper objectMapper = new Jackson2JsonObjectMapper();

	@StreamListener(AckSinkChannel.ACK)
	public void insertEsDocument(DocumentInsertionResult payload) {
		try {
			String body = objectMapper.toJson(payload);
			logger.info("received {}", body);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	interface AckSinkChannel {
		String ACK = "ack";

		@Input(ACK)
		SubscribableChannel input();
	}

}
