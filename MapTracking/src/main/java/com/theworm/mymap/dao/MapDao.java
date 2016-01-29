package com.theworm.mymap.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.theworm.mymap.model.Map;

@Component
public class MapDao {
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public List<Map> getMaps(){
		MapSqlParameterSource params = new MapSqlParameterSource();
		return jdbc.query("select * from map",params, new RowMapper(){

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map map = new Map();
				map.setMapid(rs.getInt("mapid"));
				map.setName(rs.getString("name"));
				map.setLongitude(rs.getString("longitude"));
				map.setLatitude(rs.getString("latitude"));
				return map;
			}
			
		});
	}
	
	@Transactional
	public boolean update(Map map){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(map);
		MapSqlParameterSource paramsUpdate = new MapSqlParameterSource();
		paramsUpdate.addValue("mapid", 1);
		paramsUpdate.addValue("name", map.getName());
		paramsUpdate.addValue("longitude", map.getLongitude());
		paramsUpdate.addValue("latitude", map.getLatitude());
		return jdbc.update("update map set name=:name ,longitude=:longitude,latitude=:latitude where mapid=:mapid", paramsUpdate) == 1;
	}
	
	public Map findId(int mapid){
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("mapid", mapid);
		return jdbc.queryForObject("select * from map where mapid = :mapid",params, new RowMapper(){

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map map = new Map();
				map.setMapid(rs.getInt("mapid"));
				map.setName(rs.getString("name"));
				map.setLongitude(rs.getString("longitude"));
				map.setLatitude(rs.getString("latitude"));
				return map;
			}
			
		});
	}
}
