class CreateCatalogs < ActiveRecord::Migration
  def self.up
    create_table :catalogs do |t|
      t.string :name
      t.string :image
      t.text :description
      t.integer :sort
      t.integer :parent_id

      t.timestamps
    end
  end

  def self.down
    drop_table :catalogs
  end
end
