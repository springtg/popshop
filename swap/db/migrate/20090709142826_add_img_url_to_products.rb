class AddImgUrlToProducts < ActiveRecord::Migration
  def self.up
    add_column :products, :img_url, :string
  end

  def self.down
    remove_column :products, :img_url
  end
end
