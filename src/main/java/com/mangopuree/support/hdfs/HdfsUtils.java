package com.mangopuree.support.hdfs;

import com.mangopuree.support.exception.CodeException;
import com.mangopuree.support.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class HdfsUtils {

    private final FileSystem fileSystem;

    public int saveToHdfs(String path, byte[] data) {
        Path hdfsPath = new Path(path);
        Path parentPath = hdfsPath.getParent();
        try {
            if(!fileSystem.exists(parentPath)) {
                fileSystem.mkdirs(parentPath);
            }
            try (FSDataOutputStream outputStream = fileSystem.create(hdfsPath, true)) {
                outputStream.write(data);
                outputStream.hsync();
                return data.length;
            }
        } catch (IOException e) {
            throw new CodeException(ErrorCode.HDFS_WRITE_FAIL);
        }
    }

    public byte[] downloadFromHdfs(String path) {
        Path hdfsPath = new Path(path);
        try (FSDataInputStream fsDataInputStream = fileSystem.open(hdfsPath)) {
            long fileLength = fileSystem.getFileStatus(hdfsPath).getLen();
            byte[] data = new byte[(int) fileLength];
            fsDataInputStream.readFully(data);
            return data;
        } catch (FileNotFoundException e) {
            throw new CodeException(ErrorCode.HDFS_FILE_NOT_FOUND);
        } catch (IOException e) {
            throw new CodeException(ErrorCode.HDFS_READ_FAIL);
        }
    }
}
