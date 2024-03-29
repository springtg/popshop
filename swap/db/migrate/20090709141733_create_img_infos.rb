class CreateImgInfos < ActiveRecord::Migration
  def self.up
    create_table :img_infos do |t|
      t.string :img_url
      t.integer :length
      t.integer :width
      t.string :mark
      t.integer :product_id

      t.timestamps
    end
  end

  def self.down
    drop_table :img_infos
  end
end
