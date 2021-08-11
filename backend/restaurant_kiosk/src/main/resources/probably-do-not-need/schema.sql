DROP TABLE IF EXISTS food;

CREATE TABLE food (
  food_id INT AUTO_INCREMENT PRIMARY KEY,
  food_name VARCHAR(250) NOT NULL,
  food_price DECIMAL(20, 2) NOT NULL,
  food_catagory VARCHAR(250) NOT NULL,
  food_description VARCHAR(250) NOT NULL,
  food_nutrition_info VARCHAR(250)
);