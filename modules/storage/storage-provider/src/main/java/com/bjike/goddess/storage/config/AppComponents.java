package com.bjike.goddess.storage.config;

import com.alibaba.dubbo.remoting.http.servlet.DispatcherServlet;
import com.bjike.goddess.common.jpa.boot.JpaComponents;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.ServletConfig;

/**
 * 继承扫描jpa
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Component
public class AppComponents extends JpaComponents {

}
