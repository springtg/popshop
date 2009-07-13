class Configuration < ActiveRecord::Base
  validates_uniqueness_of :keyName, :scope => :section,  :message => "Key Name must be Only one in the same section !";
  validates_format_of :keyName, :with => /\A[a-zA-Z]+\z/,  :message => "Only letters allowed" ;
  validates_format_of :section, :with => /\A[a-zA-Z]+\z/,  :message => "Only letters allowed" ;
 # validates_length_of :keyName,  :minimum => 1,  :maximum => 50, :too_short => "must have at least {{count}} words",  :too_long => "must have at most {{count}} words" 
end
