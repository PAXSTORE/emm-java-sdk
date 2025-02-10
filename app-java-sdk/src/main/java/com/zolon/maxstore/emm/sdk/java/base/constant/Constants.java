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
package com.zolon.maxstore.emm.sdk.java.base.constant;

/**
 * Created by fanjun on 2016/11/9.
 */
public class Constants {

    /**
     * Protocol input shared parameters
     */
    public static final String APP_KEY = "appKey";
    /**
     * The constant TIMESTAMP.
     */
    public static final String TIMESTAMP = "timestamp";
    /**
     * The constant SIGN_METHOD.
     */
    public static final String SIGN_METHOD = "signMethod";
    /**
     * The constant SIGNATURE.
     */
    public static final String SIGNATURE = "signature";

    public static final String ALGORITHM = "algorithm";


    /**
     * TOP default time format
     */
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * UTF-8 character set
     */
    public static final String CHARSET_UTF8 = "UTF-8";

    /**
     * Response code
     */
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    /**
     * The constant CONTENT_ENCODING.
     */
    public static final String CONTENT_ENCODING = "Content-Encoding";
    /**
     * The constant CONTENT_ENCODING_GZIP.
     */
    public static final String CONTENT_ENCODING_GZIP = "gzip";
    /**
     * The constant PARAM_DATA.
     */
    public static final String PARAM_DATA = "data";

    /**
     * Default media type
     */
    public static final String MIME_TYPE_DEFAULT = "application/octet-stream";
    /**
     * The constant ACCESS_LANGUAGE.
     */
    public static final String ACCESS_LANGUAGE = "Accept-Language";

    /**
     * HMAC signature method
     */
    public static final String SIGN_METHOD_HMAC = "hmac";


    public static final String SIGN_METHOD_SHA256 = "sha256";

    /**
     * The constant CONTENT_TYPE.
     */
    public static final String CONTENT_TYPE = "Content-Type";
    /**
     * The constant CONTENT_TYPE_JSON.
     */
    public static final String CONTENT_TYPE_JSON = "application/json;charset=utf-8";

    /**
     * The constant REQ_HEADER_DOMAIN.
     */
    public static final String REQ_HEADER_DOMAIN = "X-Market-Domain";
    /**
     * The constant REQ_HEADER_SN.
     */
    public static final String REQ_HEADER_SN = "X-Terminal-SN";

    public static final String REQ_TERMINAL_CERTIFICATE = "X-Terminal-Certificate";
    /**
     * The constant REQ_HEADER_MODEL.
     */
    public static final String REQ_HEADER_MODEL = "X-Terminal-Model";
    /**
     * The constant REQ_HEADER_APP_KEY.
     */
    public static final String REQ_HEADER_APP_KEY = "X-3rdApp-Key";
    /**
     * The constant REQ_HEADER_SDK_VERSION.
     */
    public static final String REQ_HEADER_SDK_VERSION = "X-SDK-Version";
    /**
     * The constant REQ_HEADER_PROXY_AUTHORIZATION.
     */
    public static final String REQ_HEADER_PROXY_AUTHORIZATION = "Proxy-Authorization";

    /**
     * The constant REQ_HEADER_TIMEZONE
     */
    public static final String REQ_HEADER_TIMEZONE = "Time-Zone";

    /**
     * The constant XML_FILE_PREFIX.
     */
    public static final String XML_FILE_PREFIX = "<?xml";

    public static final String JSON_FILE_PREFIX = "{";
    public static final String JSON_FILE_SUFFIX = "}";
}
