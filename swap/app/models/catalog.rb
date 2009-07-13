class Catalog < ActiveRecord::Base
  belongs_to:parent,
          :class_name=>"Catalog";
  has_many:children,
          :class_name=>"Catalog",
          :foreign_key=>"parent_id",
          :order =>"sort";
end
