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

    /**
     * HDFS에 데이터 저장
     * @param path
     * @param data
     * @return data.length
     */
    public int saveToHdfs(String path, byte[] data) {
        Path hdfsPath = new Path(path);
        Path parentPath = hdfsPath.getParent();
        try {
            // 폴더 생성
            if(!fileSystem.exists(parentPath)) {
                fileSystem.mkdirs(parentPath);
            }
            // 파일 생성
            try (FSDataOutputStream outputStream = fileSystem.create(hdfsPath, true)) {
                outputStream.write(data);
                outputStream.hsync();
                // 파일크기 반환
                return data.length;
            }
        } catch (IOException e) {
            throw new CodeException(ErrorCode.HDFS_WRITE_FAIL);
        }
    }

    /**
     * HDFS에서 파일 다운로드해서 byte[] 로 반환
     * @param path
     * @return byte[]
     */
    public byte[] downloadFromHdfs(String path) {
        Path hdfsPath = new Path(path);
        try (FSDataInputStream fsDataInputStream = fileSystem.open(hdfsPath)) {
            // 파일 크기 조회
            long fileLength = fileSystem.getFileStatus(hdfsPath).getLen();
            // 파일크기로 버퍼 생성
            byte[] data = new byte[(int) fileLength];
            // 파일 읽기
            fsDataInputStream.readFully(data);
            // 읽은 데이터 반환
            return data;
        } catch (FileNotFoundException e) {
            throw new CodeException(ErrorCode.HDFS_FILE_NOT_FOUND);
        } catch (IOException e) {
            throw new CodeException(ErrorCode.HDFS_READ_FAIL);
        }
    }
}
