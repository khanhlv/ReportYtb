package com.report.ytb.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.report.ytb.model.UserInfo;

public final class ResourceUtils {

    private static final Logger logger = LoggerFactory.getLogger(ResourceUtils.class);

    public static String read(String file) {
        InputStream inputStream = ResourceUtils.class.getResourceAsStream(file);
        try {
            return IOUtils.toString(inputStream, "UTF-8");
        } catch (IOException ex) {
            logger.error("ResourceUtils:read:String", ex);
            return null;
        }
    }

    public static List<UserInfo> readUser(String file) {
        InputStream inputStream = ResourceUtils.class.getResourceAsStream(file);
        try {
            Type listType = new TypeToken<List<UserInfo>>(){}.getType();
            return new Gson().fromJson(IOUtils.toString(inputStream, "UTF-8"), listType);
        } catch (IOException ex) {
            logger.error("ResourceUtils:readUser:UserInfo", ex);
        }
        return null;
    }

    public static List<UserInfo> readUserInternal(String file) {
        try {
            Type listType = new TypeToken<List<UserInfo>>(){}.getType();
            return new Gson().fromJson(FileUtils.readFileToString(new File(file), "UTF-8"), listType);
        } catch (IOException ex) {
            logger.error("ResourceUtils:readUser:UserInfo", ex);
        }
        return null;
    }

    public static String readInternal(String file) {
        try {
            return FileUtils.readFileToString(new File(file), "UTF-8");
        } catch (IOException ex) {
            logger.error("ResourceUtils:read:String", ex);
            return null;
        }
    }

    public static void main(String[] args) {
        ResourceUtils.readUser("/cookies.json").forEach((v) -> {
            System.out.println(v.getUSERNAME());
        });
    }
}
