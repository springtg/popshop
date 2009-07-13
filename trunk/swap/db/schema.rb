# This file is auto-generated from the current state of the database. Instead of editing this file, 
# please use the migrations feature of Active Record to incrementally modify your database, and
# then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your database schema. If you need
# to create the application database on another system, you should be using db:schema:load, not running
# all the migrations from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended to check this file into your version control system.

ActiveRecord::Schema.define(:version => 20090709142826) do

  create_table "catalogs", :force => true do |t|
    t.string   "name"
    t.string   "image"
    t.text     "description"
    t.integer  "sort"
    t.integer  "parent_id"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "configurations", :force => true do |t|
    t.string   "keyName",    :limit => 50
    t.string   "content"
    t.string   "section",    :limit => 50
    t.string   "mark"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "img_infos", :force => true do |t|
    t.string   "img_url"
    t.integer  "length"
    t.integer  "width"
    t.string   "mark"
    t.integer  "product_id"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "products", :force => true do |t|
    t.string   "name"
    t.string   "title"
    t.integer  "price",         :limit => 10, :precision => 10, :scale => 0
    t.string   "size"
    t.integer  "weight",        :limit => 10, :precision => 10, :scale => 0
    t.integer  "quantity",      :limit => 10, :precision => 10, :scale => 0
    t.date     "shopping_date"
    t.text     "description"
    t.date     "last_valid"
    t.string   "status"
    t.integer  "clicked_count"
    t.integer  "user_id"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.string   "img_url"
  end

end
