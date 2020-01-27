/*
 * Copyright (C) 2018 Marcus Hirt
 *                    www.hirt.se
 *
 * This software is free:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESSED OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * Copyright (C) Marcus Hirt, 2018
 */
package se.hirt.examples.robotshop.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

/**
 * Toolkit with various utility methods for the example.
 *
 * @author Marcus Hirt
 */
public class Utils {
	public static final String KEY_ERROR = "error";
	public static final String KEY_ACTION = "action";

	private static final String FORMAT_ACTION = "{\"" + KEY_ACTION + "\":\"message\",\"text\":\"%s\"}";
	private static final String FORMAT_ERROR = "{\"" + KEY_ERROR + "\":\"%s\"}";

	private Utils() {
		throw new UnsupportedOperationException("Tookit!");
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			Logger.log(e.getMessage());
		}
	}

	public static String errorAsJSonString(Throwable t) {
		return errorAsJSonString(t.getMessage());
	}

	public static String messageActionAsJSonString(String message) {
		return String.format(FORMAT_ACTION, message);
	}

	public static String errorAsJSonString(String message) {
		return String.format(FORMAT_ERROR, message);
	}

	public static JsonObjectBuilder errorAsJSon(Throwable error) {
		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add(KEY_ERROR, error.toString());
		return builder;
	}

	public static String getEnvWithDefault(String env, String def) {
		String s = System.getenv(env);
		if (s != null && s.length() > 0) {
			return s;
		}
		return def;
	}

	/**
	 * Sets up java.util.logging according to our settings.
	 */
	public static void initLogging() {
		try (InputStream stream = Utils.class.getClassLoader().getResourceAsStream("logging.properties")) {
			LogManager.getLogManager().readConfiguration(stream);
		} catch (IOException e) {
			System.out.println("Could not find the logging property file!");
			e.printStackTrace();
		}
	}
}
