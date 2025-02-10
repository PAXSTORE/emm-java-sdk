/*
 * *******************************************************************************
 * COPYRIGHT
 *               PAX TECHNOLOGY, Inc. PROPRIETARY INFORMATION
 *   This software is supplied under the terms of a license agreement or
 *   nondisclosure agreement with PAX  Technology, Inc. and may not be copied
 *   or disclosed except in accordance with the terms in that agreement.
 *
 *      Copyright (C) 2017 PAX Technology, Inc. All rights reserved.
 * *******************************************************************************
 */
package com.zolon.maxstore.emm.sdk.java.base.util;


import com.zolon.maxstore.emm.sdk.java.base.constant.Constants;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * String tool class.
 */
public abstract class StringUtils {

	private static final String QUOT = "&quot;";
	private static final String AMP = "&amp;";
	private static final String APOS = "&apos;";
	private static final String GT = "&gt;";
	private static final String LT = "&lt;";

	private StringUtils() {}

    /**
     * Check whether the specified string is empty.
     * <ul>
     * <li>SysUtils.isEmpty(null) = true</li>
     * <li>SysUtils.isEmpty("") = true</li>
     * <li>SysUtils.isEmpty("   ") = true</li>
     * <li>SysUtils.isEmpty("abc") = false</li>
     * </ul>
     *
     * @param value String to be checked
     * @return true /false
     */
    public static boolean isEmpty(String value) {
		int strLen;
		if (value == null || (strLen = value.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(value.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

    /**
     * Check whether the object is a numeric string, including those starting with a negative number
     *
     * @param obj the obj
     * @return the boolean
     */
    public static boolean isNumeric(Object obj) {
		if (obj == null) {
			return false;
		}
		char[] chars = obj.toString().toCharArray();
		int length = chars.length;
		if(length < 1)
			return false;
		
		int i = 0;
		if(length > 1 && chars[0] == '-')
			i = 1;
		
		for (; i < length; i++) {
			if (!Character.isDigit(chars[i])) {
				return false;
			}
		}
		return true;
	}

    /**
     * Check whether the specified string list is not empty.
     *
     * @param values the values
     * @return the boolean
     */
    public static boolean areNotEmpty(String... values) {
		boolean result = true;
		if (values == null || values.length == 0) {
			result = false;
		} else {
			for (String value : values) {
				result &= !isEmpty(value);
			}
		}
		return result;
	}

    /**
     * Convert the string of universal character encoding into Chinese character encoding.
     *
     * @param unicode the unicode
     * @return the string
     */
    public static String unicodeToChinese(String unicode) {
		StringBuilder out = new StringBuilder();
		if (!isEmpty(unicode)) {
			for (int i = 0; i < unicode.length(); i++) {
				out.append(unicode.charAt(i));
			}
		}
		return out.toString();
	}

    /**
     * Convert the name to lowercase and underscore.
     *
     * @param name the name
     * @return the string
     */
    public static String toUnderlineStyle(String name) {
		StringBuilder newName = new StringBuilder();
		int len = name.length();
		for (int i = 0; i < len; i++) {
			char c = name.charAt(i);
			if (Character.isUpperCase(c)) {
				if (i > 0) {
					newName.append("_");
				}
				newName.append(Character.toLowerCase(c));
			} else {
				newName.append(c);
			}
		}
		return newName.toString();
	}

    /**
     * Convert the name to camel case with the first letter lowercase.
     *
     * @param name the name
     * @return the string
     */
    public static String toCamelStyle(String name) {
		StringBuilder newName = new StringBuilder();
		int len = name.length();
		for (int i = 0; i < len; i++) {
			char c = name.charAt(i);
			if (i == 0) {
				newName.append(Character.toLowerCase(c));
			} else {
				newName.append(c);
			}
		}
		return newName.toString();
	}

    /**
     * Interpret the string as a date object in the format of yyyy-MM-dd HH:mm:ss.
     *
     * @param str the str
     * @return the date
     * @throws ParseException the parse exception
     */
    public static Date parseDateTime(String str) throws ParseException {
		DateFormat format = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
		return format.parse(str);
	}

    /**
     * Format the date as a string using the format yyyy-MM-dd HH:mm:ss.
     *
     * @param date the date
     * @return the string
     */
    public static String formatDateTime(Date date) {
		DateFormat format = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
		return format.format(date);
	}

    /**
     * Format the date as a string and use the specified format.
     *
     * @param date    the date
     * @param pattern the pattern
     * @return the string
     */
    public static String formatDateTime(Date date, String pattern) {
		DateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	//XML character escape includes five characters (<,>,',&,").
    /**
     * XML character escape includes five characters above
     *
     * @param value The string to be escaped
     * @return The escaped string
     */
    public static String escapeXml(String value) {
		StringBuilder writer = new StringBuilder();
		char[] chars = value.trim().toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			switch (c) {
			case '<':
				writer.append(LT);
				break;
			case '>':
				writer.append(GT);
				break;
			case '\'':
				writer.append(APOS);
				break;
			case '&':
				writer.append(AMP);
				break;
			case '\"':
				writer.append(QUOT);
				break;
			default:
				if ((c == 0x9) || (c == 0xA) || (c == 0xD) || ((c >= 0x20) && (c <= 0xD7FF))
						|| ((c >= 0xE000) && (c <= 0xFFFD)) || ((c >= 0x10000) && (c <= 0x10FFFF)))
					writer.append(c);
			}
		}
		return writer.toString();
	}

    /**
     * Get a collection of get/set attribute names of the class.
     *
     * @param clazz class
     * @param isGet Whether to obtain the read method, true is the read method, false is the write method
     * @return class properties
     * @throws IntrospectionException the introspection exception
     */
    public static Set<String> getClassProperties(Class<?> clazz, boolean isGet) throws IntrospectionException {
		Set<String> propNames = new HashSet<String>();
		BeanInfo info = Introspector.getBeanInfo(clazz);
		PropertyDescriptor[] props = info.getPropertyDescriptors();
		for (PropertyDescriptor prop : props) {
			String name = prop.getName();
			Method method;
			if (isGet) {
				method = prop.getReadMethod();
			} else {
				method = prop.getWriteMethod();
			}
			if (!"class".equals(name) && method != null) {
				propNames.add(name);
			}
		}
		return propNames;
	}

    /**
     * <p>Checks whether the <code>String</code> contains only
     * digit characters.</p>
     *
     * <p><code>Null</code> and empty String will return
     * <code>false</code>.</p>
     *
     * @param str the <code>String</code> to check
     * @return <code>true</code> if str contains only unicode numeric
     */
    public static boolean isDigits(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

	public static boolean byteNotNull(byte[] paramArrayOfByte) {
		return (null != paramArrayOfByte) && (paramArrayOfByte.length > 0);
	}
}
