package com.mangopuree.support.hdfs;

import com.mangopuree.support.exception.CodeException;
import com.mangopuree.support.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class HdfsUtils {

    private final FileSystem fileSystem;

    public int saveToHdfs(String path, byte[] data) {
        Path hdfsPath = new Path(path);
        try (FSDataOutputStream outputStream = fileSystem.create(hdfsPath, true)) {
            outputStream.write(data);
            outputStream.hsync();
            return data.length;
        } catch (IOException e) {
            throw new CodeException(ErrorCode.HDFS_FAIL);
        }
    }
}
