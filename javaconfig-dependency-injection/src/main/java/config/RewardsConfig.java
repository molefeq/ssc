package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import rewards.RewardNetwork;
import rewards.internal.RewardNetworkImpl;
import rewards.internal.account.AccountRepository;
import rewards.internal.account.JdbcAccountRepository;
import rewards.internal.restaurant.JdbcRestaurantRepository;
import rewards.internal.restaurant.RestaurantRepository;
import rewards.internal.reward.JdbcRewardRepository;
import rewards.internal.reward.RewardRepository;

@Configuration
public class RewardsConfig {

	@Autowired
	DataSource dataSource;
	
	@Bean
	public RewardRepository rewardRepository(){
		JdbcRewardRepository rewardRepository = new JdbcRewardRepository();  
		
		rewardRepository.setDataSource(dataSource);
		
		return rewardRepository;
	}

	@Bean
	public RestaurantRepository restaurantRepository(){
		JdbcRestaurantRepository restaurantRepository = new JdbcRestaurantRepository();  
		
		restaurantRepository.setDataSource(dataSource);
		
		return restaurantRepository;
	}

	@Bean
	public AccountRepository accountRepository(){
		JdbcAccountRepository accountRepository = new JdbcAccountRepository();  
		
		accountRepository.setDataSource(dataSource);
		
		return accountRepository;
	}
	
	@Bean
	public RewardNetwork rewardNetwork(){
		RewardNetworkImpl rewardNetwork = new RewardNetworkImpl(accountRepository(), restaurantRepository(), rewardRepository());  
				
		return rewardNetwork;
	}
}
