import pandas as pd

url = "food_order.csv"
df = pd.read_csv(url)

df = df.drop("cuisine_type", axis = 1)
df = df.drop("delivery_time", axis = 1)
df = df.drop("food_preparation_time", axis = 1)
df = df.drop("day_of_the_week", axis = 1)
df = df.drop("cost_of_the_order", axis = 1)

df.to_csv("nyc_restaurants_rating.csv", index=False)