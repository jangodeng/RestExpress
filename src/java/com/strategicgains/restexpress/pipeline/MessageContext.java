/*
    Copyright 2011, Strategic Gains, Inc.

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
 */
package com.strategicgains.restexpress.pipeline;

import org.jboss.netty.handler.codec.http.HttpResponseStatus;

import com.strategicgains.restexpress.Request;
import com.strategicgains.restexpress.Response;
import com.strategicgains.restexpress.response.ResponseProcessor;

/**
 * @author toddf
 * @since Feb 2, 2011
 */
public class MessageContext
{
	private Request request;
	private Response response;

	public MessageContext(Request request, Response response)
	{
		super();
		this.request = request;
		this.response = response;
	}

	public Request getRequest()
	{
		return request;
	}

	public Response getResponse()
	{
		return response;
	}

	/**
	 * @return
	 */
	public boolean shouldSerializeResponse()
	{
		return getResponse().isSerialized();
	}

	public void setResponseProcessor(ResponseProcessor processor)
	{
		getResponse().setResponseProcessor(processor);
		getRequest().setSerializationProcessor(processor.getSerializer());
	}

	public boolean hasResponseProcessor()
	{
		return getResponse().hasResponseProcessor();
	}

	public ResponseProcessor getResponseProcessor()
	{
		return getResponse().getResponseProcessor();
	}

	public String getContentType()
	{
		return getResponse().getContentType();
	}

	/**
	 * @return
	 */
	public Throwable getException()
	{
		return getResponse().getException();
	}

	/**
	 * @param rootCause
	 */
	public void setException(Throwable throwable)
	{
		getResponse().setException(throwable);
	}

	/**
	 * @param httpStatus
	 */
	public void setHttpStatus(HttpResponseStatus httpStatus)
	{
		getResponse().setResponseStatus(httpStatus);
	}
}
