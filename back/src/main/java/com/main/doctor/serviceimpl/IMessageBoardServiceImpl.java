package com.main.doctor.serviceimpl;

import com.main.doctor.mapper.MessageBoardMapper;
import com.main.doctor.entity.MessageBoard;
import com.main.doctor.service.IMessageBoardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 留言板接口实现
 * @author mobai
 */
@Service
@Transactional
public class IMessageBoardServiceImpl extends ServiceImpl<MessageBoardMapper, MessageBoard> implements IMessageBoardService {

}