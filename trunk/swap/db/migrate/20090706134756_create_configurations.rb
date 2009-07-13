class CreateConfigurations < ActiveRecord::Migration
  def self.up
    create_table :configurations do |t|
      t.string :keyName
      t.string :content
      t.string :section
      t.string :mark

      t.timestamps
    end
  end

  def self.down
    drop_table :configurations
  end
end
