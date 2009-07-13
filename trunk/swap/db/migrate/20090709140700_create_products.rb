class CreateProducts < ActiveRecord::Migration
  def self.up
    create_table :products do |t|
      t.string :name
      t.string :title
      t.decimal :price
      t.string :size
      t.decimal :weight
      t.decimal :quantity
      t.date :shopping_date
      t.text :description
      t.date :last_valid
      t.string :status
      t.integer :clicked_count
      t.integer :user_id

      t.timestamps
    end
  end

  def self.down
    drop_table :products
  end
end
