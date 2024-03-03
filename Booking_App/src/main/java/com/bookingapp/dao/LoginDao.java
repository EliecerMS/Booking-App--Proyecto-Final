/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bookingapp.dao;

import com.bookingapp.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kenca
 */
public interface LoginDao extends JpaRepository<Login,Long>{
    
}
